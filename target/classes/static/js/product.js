$(document).ready(function() {
	loadData();
	//loadCategoryDropdownData();

});

//Load Data function
function loadData() {
	$.ajax({
		url : "/product/",
		type : "GET",
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(result) {
			var jsonResponse = $.parseJSON(JSON.stringify(result));
			console.log("---> ", jsonResponse.data);
			console.log("---> ", jsonResponse.data[0].vendorProduct.storeName);// array and obect
			var html = '';
			$.each(jsonResponse.data, function(key, item) {
				html += '<tr>';
				html += '<td>' + item.productid + '</td>';
				html += '<td>' + item.productName + '</td>';
				//$.each(jsonResponse.data[key].vendorProduct, function(j, userData) {
					html += '<td>' + jsonResponse.data[key].vendorProduct.storeName+ '</td>';
					html += '<td>' + jsonResponse.data[key].categoryProduct.categoryName+ '</td>';
					html += '<td>' + jsonResponse.data[key].subcategoryProduct.subcategoryName + '</td>';
					
				//})
				html += '</tr>';
			});

			$('.tbody').html(html);
		},
		error : function(errormessage) {
			alert(errormessage.responseText);
		}
	});
}
