//Load Data in Table when documents is ready
$(document).ready(function () {
    loadData();
});


//Add Data Function
function Add() {
    var res = validate();
    if (res == false) {
        return false;
    }
    var categoryObj = {
    		categoryName : $('#categoryName').val(),
          };
    	
    $.ajax({
        url: "/category/save",
        data: JSON.stringify(categoryObj),
        type: "POST",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
        	 loadData();
             $('#myModal').modal('hide');
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

//Load Data function
function loadData() {
    $.ajax({
        url: "/category/",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
        	var jsonResponse= $.parseJSON(JSON.stringify(result));
			var html = '';
			$.each(jsonResponse.data, function (key, item) {
				html += '<tr>';
                html += '<td>' + item.categoryid + '</td>';
                html += '<td>' + item.categoryName + '</td>';
                html += '<td><a href="#" onclick="return getbyID(' + item.categoryid + ')">Edit</a> | <a href="#" onclick="Delele(' + item.categoryid + ')">Delete</a></td>';
                html += '</tr>';
            });
			
            $('.tbody').html(html);
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}


//Valdidation using jquery
function validate() {
    var isValid = true;
    if ($('#categoryName').val().trim() == "") {
        $('#categoryName').css('border-color', 'Red');
        $('#info').html("Category should not be empty");
        isValid = false;
    }
    else {
        $('#categoryName').css('border-color', 'lightgrey');
    }
    
    return isValid;
}

function clearTextBox() {
	   
    $('#categoryName').val("");
    $('#btnUpdate').hide();
    $('#btnAdd').show();
    $('#categoryName').css('border-color', 'lightgrey');
  
}