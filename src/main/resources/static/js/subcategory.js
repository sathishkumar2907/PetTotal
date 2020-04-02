//Load Data in Table when documents is ready
$(document).ready(function() {
	loadData();
	loadCategoryDropdownData();

});

//Load Data function
function loadData() {
	$.ajax({
		url : "/category/",
		type : "GET",
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(result) {
			var jsonResponse = $.parseJSON(JSON.stringify(result));
			var html = '';
			$.each(jsonResponse.data, function(key, item) {
				$.each(jsonResponse.data[key].subcategories, function(j, userData) {
					html += '<tr>';
					html += '<td>' + userData.subcategoryid + '</td>';
					html += '<td>' + item.categoryName + '</td>';
					html += '<td>' + userData.subcategoryName+ '</td>';
					html += '<td><a href="#" onclick="return getbyID('+ item.categoryid+ ')">Edit</a> | <a href="#" onclick="Delele('+ item.categoryid + ')">Delete</a></td>';
					html += '</tr>';
				})
			});

			$('.tbody').html(html);
		},
		error : function(errormessage) {
			alert(errormessage.responseText);
		}
	});
}

//Add Data Function
function Add() {

	//$("#cat_name").on('change',function(event){
	var subcategoryObj = {
		categoryid : $('#cat_name').val(),
		subcategoryName : $('#subcategoryName').val()
	};
	console.log(subcategoryObj.categoryid);
	$.ajax({
		url : "/subcategory/save/" + subcategoryObj.categoryid,
		data : JSON.stringify(subcategoryObj),
		type : "POST",
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(result) {
			// loadData();
			$('#myModal').modal('hide');
		},
		error : function(errormessage) {
			alert(errormessage.responseText);
		}
	});
	// });
}

//Load Data function
function loadCategoryDropdownData() {
	$.ajax({
		url : "/category/",
		type : "GET",
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		success : function(result) {
			var jsonResponse = $.parseJSON(JSON.stringify(result));
			console.log("son----> ", jsonResponse);

			$.each(jsonResponse.data, function(key, item) {
				$("#cat_name").append(
						$("<option></option>").val(item.categoryid).html(
								item.categoryName));
			});

		},
		error : function(errormessage) {
			alert(errormessage.responseText);
		}
	});
}

function clearTextBox() {

	$('#subcategoryName').val("");
	$('#btnUpdate').hide();
	$('#btnAdd').show();
	$('#subcategoryName').css('border-color', 'lightgrey');

}
