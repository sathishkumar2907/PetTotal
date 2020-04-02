//Load Data in Table when documents is ready
$(document).ready(function () {
    loadData();
});


//Load Data function
function loadData() {
    $.ajax({
        url: "/vendor/",
        type: "GET",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
        	var jsonResponse= $.parseJSON(JSON.stringify(result));
			var html = '';
			$.each(jsonResponse.data, function (key, item) {
				html += '<tr>';
                html += '<td>' + item.venorId + '</td>';
                html += '<td>' + item.storeName + '</td>';
                html += '<td>' + item.storeContact + '</td>';
                html += '<td>' + item.ownerName + '</td>';
                html += '<td>' + item.ownerContact + '</td>';
                html += '<td>' + item.location + '</td>';
                html += '<td><a href="#" onclick="return getbyID(' + item.venorId + ')">Edit</a> | <a href="#" onclick="Delele(' + item.venorId + ')">Delete</a></td>';
                html += '</tr>';
            });
			
            $('.tbody').html(html);
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

//Add Data Function
function Add() {
    var res = validate();
    if (res == false) {
        return false;
    }
    var vendorObj = {
    		storeName    : $('#storeName').val(),
    		storeContact : $('#storeContact').val(),
    		ownerName    : $('#ownerName').val(),
    		ownerContact : $('#ownerContact').val(),
    		location     : $('#location').val()
    };
    $.ajax({
        url: "/vendor/save",
        data: JSON.stringify(vendorObj),
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

//Function for getting the Data Based upon Employee ID
function getbyID(vendorID) {
    $('#storeName').css('border-color', 'lightgrey');
    $('#storeContact').css('border-color', 'lightgrey');
    $('#ownerName').css('border-color', 'lightgrey');
    $('#ownerContact').css('border-color', 'lightgrey');
    $('#location').css('border-color', 'lightgrey');
    
    $.ajax({
    	url: "/vendor/" + vendorID,
        type: "GET",
        contentType: "application/json;charset=UTF-8",
        dataType: "json",
        success: function (result) {
        	$('#venorId').val(result.data.venorId);
            $('#storeName').val(result.data.storeName);
            $('#storeContact').val(result.data.storeContact);
            $('#ownerName').val(result.data.ownerName);
            $('#ownerContact').val(result.data.ownerContact);
            $('#location').val(result.data.location);
            $('#myModal').modal('show');
            $('#btnUpdate').show();
            $('#btnAdd').hide();
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
    return false;
}
//function for updating employee's record
function Update() {
    var res = validate();
    if (res == false) {
        return false;
    }
    var vendorObj = {
            venorId: $('#venorId').val(),
    		storeName: $('#storeName').val(),
    		storeContact: $('#storeContact').val(),
    		ownerName: $('#ownerName').val(),
    		ownerContact: $('#ownerContact').val(),
    		location: $('#location').val(),
    };
    $.ajax({
        url: "/vendor/update",// + EmpID
        data: JSON.stringify(vendorObj),
        type: "PUT",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success: function (result) {
            loadData();
            $('#myModal').modal('hide');
            $('#storeName').val("");
            $('#storeContact').val("");
            $('#ownerName').val("");
            $('#ownerContact').val("");
            $('#location').val("");
        },
        error: function (errormessage) {
            alert(errormessage.responseText);
        }
    });
}

//function for deleting employee's record
function Delele(ID) {
    var ans = confirm("Are you sure you want to delete this Record?");
    if (ans) {
        $.ajax({
            url: "/vendor/delete/" + ID,
            type: "POST",
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            success: function (result) {
                loadData();
            },
            error: function (errormessage) {
                alert(errormessage.responseText);
            }
        });
    }
}

//Valdidation using jquery
function validate() {
    var isValid = true;
    if ($('#storeName').val().trim() == "") {
        $('#storeName').css('border-color', 'Red');
        isValid = false;
    }
    else {
        $('#storeName').css('border-color', 'lightgrey');
    }
    if ($('#storeContact').val().trim() == "") {
        $('#storeContact').css('border-color', 'Red');
        isValid = false;
    }
    else {
        $('#storeContact').css('border-color', 'lightgrey');
    }
    if ($('#ownerName').val().trim() == "") {
        $('#ownerName').css('border-color', 'Red');
        isValid = false;
    }
    else {
        $('#ownerName').css('border-color', 'lightgrey');
    }
    if ($('#ownerContact').val().trim() == "") {
        $('#ownerContact').css('border-color', 'Red');
        isValid = false;
    }
    else {
        $('#ownerContact').css('border-color', 'lightgrey');
    }
    if ($('#location').val().trim() == "") {
        $('#location').css('border-color', 'Red');
        isValid = false;
    }
    else {
        $('#location').css('border-color', 'lightgrey');
    }
    return isValid;
}

//Function for clearing the textboxes
function clearTextBox() {
   
    $('#storeName').val("");
    $('#storeContact').val("");
    $('#ownerName').val("");
    $('#ownerContact').val("");
    $('#btnUpdate').hide();
    $('#btnAdd').show();
    $('#storeName').css('border-color', 'lightgrey');
    $('#storeContact').css('border-color', 'lightgrey');
    $('#ownerName').css('border-color', 'lightgrey');
    $('#ownerContact').css('border-color', 'lightgrey');
}