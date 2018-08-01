$(function () {
    $(function(){
        var moneys = $(".moneyNum");
        moneys.each(function(i){
            var num = $(this).html();
            if($(this).is('input')){
                num = $(this).val();
            }
            num = (parseFloat(num)).toLocaleString();
            //末位补0
            var arr = num.split(".");
            if(arr.length==1){
                num = num+".00";
            }else if(arr.length>1){
                if(arr[1].length==1){
                    num = num+"0";
                }
            }
            $(this).html(num);
            if($(this).is('input')){
                $(this).val(num);
            }
        });
        moneys.css("text-align","right");
    });
});