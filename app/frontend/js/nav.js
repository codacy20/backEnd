$(document).ready(function () {
    var show = true;
    $('.icon').click(function () {
        if (show == true) {
            $(".mobilenav").fadeToggle(500);
            $(".top-menu").toggleClass("top-animate");
            $(".mid-menu").toggleClass("mid-animate");
            $(".bottom-menu").toggleClass("bottom-animate");
        }
        else if (show == false) {
            $(".mobilenav").hide();
        }
    });
});
