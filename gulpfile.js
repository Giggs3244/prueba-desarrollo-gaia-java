/**
 * Tareas Gulp ambiente de produccion
 * Inicializacion de los valores y librerias para las tareas del archivo gulp.
 *
 * @autor: carlos.cardona
 *
 */
const gulp = require('gulp');
const clean = require('gulp-clean');
const concat = require('gulp-concat');
const minifyCss = require('gulp-cssmin');
const jshint = require('gulp-jshint');
const sass = require('gulp-sass');
const rename = require('gulp-rename');
const uglify = require('gulp-uglify');
const bowerFiles = require('gulp-main-bower-files');
const angularFilesort = require('gulp-angular-filesort');
const gulpFilter = require('gulp-filter');
const notify = require('gulp-notify');

var paths;
paths = {
    dev: './src/main/webapp/_dev/',
    dist: './src/main/webapp/public/dist/',
    sass: 'sass/**/*.scss',
    css: 'css/**/*.css',
    js: 'app/**/*.js',
    sprites: 'sprites/',
    html: '*.html',
    img: 'img/',
    fonts: 'fonts/'
};

gulp.task("clean", function () {
    gulp.src([paths.dist + "app/", paths.dist + "js/", paths.dist + "css/"], {
        read: false
    }).pipe(clean());
});

gulp.task('copy:img', function() {
    return gulp.src(paths.dev + 'images/*.{gif,jpg,png}')
        .pipe(gulp.dest(paths.dist + "images/"));
});

gulp.task('copy:html', function() {
    return gulp.src(paths.dev + 'views/**/*.html')
        .pipe(gulp.dest(paths.dist + 'views/'));

});

gulp.task('copy:fonts', function() {
    return gulp.src(paths.dev + 'fonts/*')
    .pipe(gulp.dest(paths.dist + 'fonts/'));
    
});

/**
 * Task for creation css.min files.
 */
gulp.task("css:min", function () {
    return gulp.src(paths.dev + paths.css)
        /*.pipe(sass({
            http_path: "/",
            project: paths.dev,
            sass: 'sass'
        }))
        .on("error", function (error) {
            console.log(error);
            this.emit('end');
        })*/
        .pipe(minifyCss())
        .pipe(rename({
            suffix: '.min'
        })).pipe(gulp.dest(paths.dist + 'css/'));
});

/**
 * Task for creation app.js file, for all app call on js task.
 */
gulp.task("js:min", function () {
    gulp.src([paths.dev + paths.js])
        .pipe(angularFilesort())
        .pipe(concat('app.min.js'))
        //.pipe(uglify())
        .pipe(gulp.dest(paths.dist + 'app/'));
});

// lint
gulp.task("lint", function () {
    gulp.src(paths.dev + paths.js)
        .pipe(jshint())
        .pipe(jshint.reporter('default', {verbose: true}));
});

// update vendor css
gulp.task("update_vendor_css", function () {
    var filter = gulpFilter('**/*.css');
    return gulp.src('./bower.json')
        .pipe(bowerFiles({
            paths: {
                bowerDirectory: paths.dev + 'vendor',
                bowerrc: '.bowerrc',
                bowerJson: 'bower.json'
            },
            debugging: true
        }))
        .pipe(filter)
        .pipe(concat('vendor.css'))
        .pipe(gulp.dest(paths.dist + 'vendor'))
        .pipe(notify({ message: 'Bower css task complete' }));
});

// update vendor js
gulp.task("update_vendor_js", function () {
    var filter = gulpFilter('**/*.js');
    return gulp.src('./bower.json')
       .pipe(bowerFiles({
           paths: {
               bowerDirectory: paths.dev + 'vendor',
               bowerrc: '.bowerrc',
               bowerJson: 'bower.json'
           },
           debugging: true
       }))
       .pipe(filter)
       .pipe(concat('vendor.js'))
//       .pipe(uglify())
       .pipe(gulp.dest(paths.dist + 'vendor'))
       .pipe(notify({ message: 'Bower task complete' }));
});

// Watch Files For Changes
gulp.task('watch', function() {
    gulp.watch(paths.dev + paths.js, ['lint', 'js:min']);
    gulp.watch('sass/*.scss', ['sass']);
});

//gulp.task("default", ["clean", "lint", "copy:img", "copy:html", "css:min", "js:min"]);
gulp.task("default", ["clean", "update_vendor_js", "update_vendor_css", "lint", "copy:img", "copy:html", "css:min", "js:min", "copy:fonts"]);