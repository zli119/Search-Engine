jQuery(document).ready(function($){
    var search_box = $(".search-box");
        
    $(".start-search").on("click", function(event){
        var search_terms = search_box.val();
        $.ajax({
            type:"POST",
            url:"/query",
            data:{
            	terms: search_terms
            },
            success:function(data){
            	$(".results").empty();
                if(data.length > 0){
                	_displayData(data);
                }else{
                	var no_data = $("<h1></h1>").text("No matching article");
                	$(".results").append(no_data);
                }
            },
            error:function(data){
                console.log(data);
            }
        });

    });
    
    
    //private function to append child elements
    function _displayData(data){
    	data.sort(function(x, y){
    		return y.ranking - x.ranking;
    	});
        for(var i = 0; i < data.length; i++){
            var div = $("<div></div>").addClass("article");
            var title = $("<h2></h2>").addClass("title").text(data[i].title);
            var url = $("<p></p>").text("ranking: "+ data[i].ranking);
            var link = $("<a></a>").attr("href", data[i].url).text(data[i].url);
            div.append(title, url, link);
            $(".results").append(div);
        }
    };
});