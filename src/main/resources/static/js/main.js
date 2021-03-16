function goToFieldValuePage(id) {
	console.log("" + id);
	location.href = "/info-details?folderId=" + id;
}

function copyFieldValue(valueToCopy){
	var p1 = document.getElementById(valueToCopy);
    var hiddenField = document.getElementById("copyText");
    hiddenField.value = p1.innerHTML;
    hiddenField.select();
    document.execCommand("copy");
    alert("Copied the text: " + hiddenField.value);
}

function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}

function deleteFieldValue(fieldId , folderId){
	console.log("id is" + fieldId);
	location.href = "/delete-info?fieldId=" + fieldId +"&folderId=" +folderId;
}

function deleteFolderValue(folderId){
	location.href = "/delete-folder?folderId=" + folderId;
}

function editFolderValue(folderId, folderName){
	document.getElementById("editFolderForm").style.display = "block"
	$(".modalFolderId").val(folderId);
	$(".modalFolderName").val(folderName);
}

function editFieldValue(fieldId , fieldName , fieldValue){
	document.getElementById("editFieldForm").style.display = "block"
	$(".modalFieldId").val(fieldId);
	$(".modalFieldName").val(fieldName);
	$(".modalFieldValue").val(fieldValue);
}

function closeEditFolderForm() {
  document.getElementById("editFolderForm").style.display = "none";
}

function closeEditFieldForm() {
  document.getElementById("editFieldForm").style.display = "none";
}


