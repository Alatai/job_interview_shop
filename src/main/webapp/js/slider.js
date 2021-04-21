'use script';

$(function () {
    let arrowLeft = $('.arrow-l');
    let arrowRight = $('.arrow-r');
    let banner = $('.banner');
    let bannerWidth = banner.width;

    let timer = setInterval(function () {
        arrowRight.click();
    }, 2000);

    banner.onmouseenter = function () {
        arrowLeft.style.display = 'block';
        arrowRight.style.display = 'block';

        clearInterval(timer);
        timer = null;
    };

    banner.onmouseleave= function () {
        arrowLeft.style.display = "none";
        arrowRight.style.display = "none";

        timer = setInterval(function () {
            arrowRight.click();
        }, 2000);
    };
});

/**
 * アニメーション効果
 * @param obj
 * @param target
 * @param callback
 */
function animate(obj, target, callback) {
    clearInterval(obj.timer);

    obj.timer = setInterval(function () {
        let step = (target - obj.offsetWidth) / 10;
        step = step > 0 ? Math.ceil(step) : Math.floor(step);

        if (obj.offsetLeft === target) {
            clearInterval(obj.timer);

            callback && callback();
        }

        obj.style.left = obj.offsetLeft + step + 'px';
    }, 15);
}