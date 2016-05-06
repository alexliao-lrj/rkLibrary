$(document).ready(function(){
    $("#publish_time").datepicker();
    $("select#bookcaseid").selecter();

    var child=$("select#continuetype").children();
		$("select#type").change(function(){
			if($(this).val()==""){
			$.each(child,function(i,val){
				$(this).remove();
			});
                var newOption1=new Option("寤虹瓚","1");
                var newOption2=new Option("璁＄畻鏈�","2");
                var newOption3=new Option("鏈烘","3");
                var newOption3=new Option("鐢垫皵","4");
                var newOption3=new Option("鍦熸湪","5");
                var newOption3=new Option("鐑兘","6");
                var newOption3=new Option("鑸ぉ","7");
                $("select#continuetype").append(newOption1); 
                $("select#continuetype").append(newOption2); 
                $("select#continuetype").append(newOption3);
                $("select#continuetype").append(newOption4); 
                $("select#continuetype").append(newOption5); 
                $("select#continuetype").append(newOption6); 
                $("select#continuetype").append(newOption7);  
			}else if($(this).val()=="鏂囧"){
			$.each(child,function(i,val){
				$(this).remove();
			});
				var newOption1=new Option("灏忚","1");
				var newOption2=new Option("鏁ｆ枃","2");
				var newOption3=new Option("浼犺","3");
				$("select#continuetype").append(newOption1); 
				$("select#continuetype").append(newOption2); 
				$("select#continuetype").append(newOption3); 
			}else if($(this).val()=="鏉傚織"){
			$.each(child,function(i,val){
				$(this).remove();
			});
                var newOption1=new Option("鏈堝垔","1");
                var newOption2=new Option("鏈熷垔","2");
                var newOption3=new Option("鍛ㄦ姤","3");
                $("select#continuetype").append(newOption1); 
                $("select#continuetype").append(newOption2); 
                $("select#continuetype").append(newOption3); 
			}else if($(this).val()=="宸ュ叿涔"){
			$.each(child,function(i,val){
				$(this).remove();
			});
                var newOption1=new Option("瀛楀吀","1");
                var newOption2=new Option("璇嶆眹","2");
                $("select#continuetype").append(newOption1); 
                $("select#continuetype").append(newOption2); 
            }else{
            $.each(child,function(i,val){
				$(this).remove();
			});
                var newOption1=new Option("鐢绘姤","1");
                var newOption2=new Option("涔︽硶","2");
                var newOption3=new Option("鍏朵粬","3");
                $("select#continuetype").append(newOption1); 
                $("select#continuetype").append(newOption2); 
                $("select#continuetype").append(newOption3); 
            }
		});
	$('#submit_first').click(function(){
		var errors=0;
		var re=/^\w+$/;
        var fields=$("#first #bookid,#first #author,#first #publisher,#first #bookname");
        fields.each(function(){
        	var value=$(this).val();
        	if(value.length<1){
        		$(this).addClass("error");
        		$(this).parent().effect("shake",{times:3},1000);
        		errors++;
        	}else{
        		$(this).addClass("success");
        	}
        });
        if(!errors){
        	$("div#first").hide();
            $("div#type2").show();
            $("div.bar").attr({style:'width:33%'});
            $("p").html("");
            $("div.bar").html("瀹屾垚搴︼細33%");
        }	
	});
	$('#submit_type2').click(function(){
		var value=$("#price").val();
        var re=/^\d+(.\d+)?$/;
        if(re.test(value)){
		$("div#type2").hide();
        $("div#third").show();
        $("div.bar").attr({style:'width:67%'});
        $("div.bar").html("瀹屾垚搴︼細67%");
        $("p").html("");
       } 
	});
	$('#submit_third').click(function(){
		$("div#third").hide();
        $("div#fourth").show();
        var getJSON=new Array(
        $("#bookid").val(),
        $("#bookname").val(),
        $("#publisher").val(),
        $("#author").val(),
        $("#publish_time").val(),
        $("#translator").val(),
        $("#stock").val(),
        $("#bookcaseid").val(),
        $("select#type").val()+"/"+$("select#continuetype").val(),
        $("#price").val()
        );
    
        var trs=$("div#fourth table tr");
        trs.each(function(){
            $(this).children("td:nth-child(2)").html(getJSON[$(this).index()]);
        });
            $("div.bar").attr({style:'width:100%'});
            $("div.bar").html("瀹屾垚搴︼細100%");
	});
	$('#submit_fourth').click(function(){
       $.post("addBook",{
            "briefbook.id":$("#bookid").val(),
           "briefbook.name":$("#bookname").val(),
           "briefbook.author": $("#author").val(),
           "briefbook.publisher":$("#publisher").val(),
           "briefbook.publish_time":$("#publish_time").val(),
           "briefbook.translator":$("#translator").val(),
           "briefbook.stock": $("#stock").val(),
           "briefbook.bookcaseid":$("#bookcaseid").val(),
           "briefbook.type":$("select#type").val(),
           "briefbook.type2":$("select#continuetype").val(),
           "briefbook.price":$("#price").val()
       },function(data){
            alertify.confirm(data+",缁х画娣诲姞鍚︼紵",function(e){
                if(e){
                   window.location.href="newBook.jsp";
                }else{
                  window.location.href="book_infor.action?book.id="+$("#bookid").val();
                }
            });
               
       });
	});
	});
	function setImagePreview() {
		var docObj = document.getElementById("fileField");
		var imgObjPreview = document.getElementById("preview");
		if (docObj.files && docObj.files[0]) {
			//鐏嫄涓嬶紝鐩存帴璁緄mg灞炴� 
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '190px';
			imgObjPreview.style.height = '250px';
			//imgObjPreview.src = docObj.files[0].getAsDataURL(); 
			//鐏嫄7浠ヤ笂鐗堟湰涓嶈兘鐢ㄤ笂闈㈢殑getAsDataURL()鏂瑰紡鑾峰彇锛岄渶瑕佷竴涓嬫柟寮�
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE涓嬶紝浣跨敤婊ら暅 
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			var localImagId = document.getElementById("localImag");
			//蹇呴』璁剧疆鍒濆澶у皬 
			localImagId.style.width = "190px";
			localImagId.style.height = "250px";
			//鍥剧墖寮傚父鐨勬崟鎹夛紝闃叉鐢ㄦ埛淇敼鍚庣紑鏉ヤ吉閫犲浘鐗�
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("鎮ㄤ笂浼犵殑鍥剧墖鏍煎紡涓嶆纭紝璇烽噸鏂伴�鎷�");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}