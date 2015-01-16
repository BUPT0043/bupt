/**
 * jquery.pagination.js
 * Author:lin.cheng
 * Date: 2014-03-16
 */
(function($){
    $.fn.pagination = function(options){
        var opts = $.extend({}, $.fn.pagination.defaults, options);
        return this.each(function(){
            var $this = $(this);

            /**
             *计算总页数
             */
            function calculatePages(data){
                return ((data.recordCount % opts.pageSize) == 0) ?  Math.floor(data.recordCount / opts.pageSize) : (Math.floor(data.recordCount / opts.pageSize) + 1);
            }

            /**
             *计算开始结束页码
             */
            function getInterval(data){
                // 页面显示最大页码
                var maxPage = 10;
                var center = maxPage / 2;
                var start = 0;
                var end = 0;
                var pageCount = calculatePages(data);
                // 最大页数不超过maxPage
                if (pageCount <= maxPage) {
                    start = 1;
                    end = pageCount;
                } else {
                    // 如果当前页超过最大显示页码一半
                    if (opts.currentPage > center) {
                    	var totalPage=parseInt(opts.currentPage)+parseInt(center);
                        // 尾部不够显示，总显示页码数量为maxPage
                        if (totalPage> pageCount) {
                            start = opts.currentPage - (maxPage - (pageCount - opts.currentPage)) + 1;
                            end = pageCount;
                        } else {
                            // 当前页控制显示为中间值
                        	start = parseInt(opts.currentPage) - parseInt(center) + 1;
                            end = parseInt(opts.currentPage) + parseInt(center);
                        }
                    } else {
                        // 当前页码不足最大显示的一半
                        start = 1;
                        end = maxPage;
                    }
                }
                return [start,end];
            }

            /**
             *选择页码，翻页
             */
            function selectPage(page){
                opts.currentPage = page;
                draw();
            }

            /**
             *填充显示链接html
             */
            function draw(){
                if(opts.ajax.url != null) {
                    var transData = ((opts.ajax.data == null) ? (new Object()) : opts.ajax.data);
                    transData.pageSize = opts.pageSize;
                    transData.currentPage = opts.currentPage;
                    $.ajax({
                        url : opts.ajax.url,
                        data : transData,
                        dataType : opts.ajax.dataType,
                        success : function(data){
                            opts.ajax.callback(data);
                            if(data == null || data == ""){
                                return;
                            }
                            if(data.recordCount == undefined){
                                return;
                            }else{
                                //清空
                                $this.empty();
                                if(data.recordCount == 0){
                                    return;
                                }else{
                                    //获取页码
                                    var pageCount = calculatePages(data);
                                    var interval = getInterval(data);
                                    // 页号越界处理
                                    if (opts.currentPage > opts.pageCount) {
                                        opts.currentPage = pageCount;
                                    }
                                    if (opts.currentPage < 1) {
                                        copts.currentPage = 1;
                                    }
                                    $this.append('<lable class="all">共<b>' + pageCount + '</b>页</label>');

                                    if(opts.currentPage == 1){
                                        $this.append('<span class="disabled">首页</span><span class="disabled">上一页</span>');
                                    } else {
                                        $this.append('<a href="javascript:void(0)" class="first">首页</a><a href="javascript:void(0)" class="pre">上一页</a>');
                                    }

                                    for(var i = interval[0]; i <= interval[1]; i++){
                                        if(opts.currentPage == i){
                                            $this.append('<b class="current">' + i + '</b>');
                                        } else {
                                            $this.append('<a href="javascript:void(0)" class="cur">' + i + '</a>');
                                        }
                                    }

                                    if(opts.currentPage == pageCount){
                                        $this.append('<span class="disabled">下一页</span><span class="disabled">尾页</span>');
                                    } else {
                                        $this.append('<a href="javascript:void(0)" class="next">下一页</a><a href="javascript:void(0)" class="end">尾页</a>');
                                    }

                                    $(".first").bind("click",function(){
                                        selectPage(1);
                                    });

                                    $(".end").bind("click",function(){
                                        selectPage(calculatePages(data));
                                    });

                                    $(".pre").bind("click",function(){
                                        selectPage(parseInt(opts.currentPage) - 1);
                                    });

                                    $(".next").bind("click",function(){
                                        selectPage(parseInt(opts.currentPage) + 1);
                                    });

                                    $(".cur").bind("click", function(){
                                        selectPage($(this).text());
                                    });
                                }
                            }
                        }
                    });
                }
            }
            draw();
        });
    };

    $.fn.pagination.defaults = {
            ajax : {
                url : null, //url地址
                data : null, // 数据，必须是对象
                dataType : 'json', //数据类型
                type : 'get', //提交类型
                callback : function(){} //成功回调函数
            },
            pageSize : 5, //每页显示数量
            currentPage : 1 //当前页
    };

})(jQuery);