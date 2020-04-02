$(document).ready(function(){
	$.ajax({
		type: "GET",
		url : "/contactus/",
		cache: false,
		success : function(result){
			if(result){
				$('#getResultDiv ul').empty();
				
				var jsonResponse= $.parseJSON(JSON.stringify(result));
				console.log("json--->", jsonResponse.data);
				
				var table = $("#contactusTable").DataTable({
					"aaData" : result.data,
					"aoColumns": [
						{"mData" : "contactsid"},
						{"mData" : "name"},
						{"mData" : "contactNumber"},
						{"mData" : "contactEmail"},
						{"mData" : "contactMessage"}
					],
					"paging" : true,
					"pageLength" : 8,
					"ordering" : true,
					"order" : [0,"asc"],
					
					
				});
				
			}else{
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("Fail : ", result);
			}
				
			},
			error : function(e){
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR : ", e);
			}
		
	})
})