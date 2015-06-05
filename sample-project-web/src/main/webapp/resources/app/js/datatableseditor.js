+function ($) {
  'use strict';

  // DataTablesEditor PUBLIC CLASS DEFINITION
  // ==============================

  var DataTablesEditor = function (element, options) {
    this.$element  = $(element)
    this.options   = $.extend({}, DataTablesEditor.DEFAULTS, options)
    this.$dataTabls = this.$element.DataTable(this.options.dataTableConfig)
    var $dataTablsVar = this.$dataTabls
    this.$element.find('tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
        	$dataTablsVar.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    } );
  }

  DataTablesEditor.VERSION  = '0.0.1'

  DataTablesEditor.DEFAULTS = {
      language :  {
    	  noRowSelectMessage : "请选择一条记录",
    	  delteConfirmMessage : "真的要删除这条记录吗？"
      }
  }

  DataTablesEditor.prototype.getForm = function () {
	  return $('[dataTablesEditorRole="form"][data-target=' + this.$element.attr('id') + ']')
  }

  DataTablesEditor.prototype.getModal = function () {
	  return $('[dataTablesEditorRole="modal"][data-target=' + this.$element.attr('id') + ']')
  }

  DataTablesEditor.prototype.clearModal = function () {
	  var modal = this.getModal();
	  modal.find('[dataTablesEditorRole="modal.input"]').val("");
	  modal.find('[dataTablesEditorRole="modal.error"]').text("");
  }

  DataTablesEditor.prototype.resetModalStatus = function (action) {
	  var modal = this.getModal();
	  modal.find('[data-readonly="' + action + '"]').attr("readonly",true);
	  modal.find('[data-readonly!="' + action + '"]').attr("readonly",false);

	  modal.find('[data-hide="' + action + '"]').hide();
	  modal.find('[data-hide!="' + action + '"]').show();
  }

  DataTablesEditor.prototype.setData = function (dataObj) {
	  var form = this.getForm();
	  for(var name in dataObj) {
		form.find('[dataTablesEditorRole="modal.input"][data-target="' + name + '"]').val(dataObj[name]);
	  }
  }

  DataTablesEditor.prototype.setError = function (fieldErrors) {
	  if(fieldErrors == null) {
		  return false;
	  }

	  var form = this.getForm();
	  $.each(fieldErrors, function(index,element){
		  form.find('[dataTablesEditorRole="modal.error"][data-target="' + element.name + '"]').text(element.status).show();
	  })
	  return true;
  }

  DataTablesEditor.prototype.postData = function (action, callback) {

	  var $this = this;
	  var url = this.options.url + "?action=" + action;
	  $.ajax({
          type: "POST",
          dataType: "json",
          url: url,
          data: $(this.getForm()).serialize(),
          success: function (result) {
        	  callback.call($this, result)
          },
          error: function(data) {
              alert("error:"+data.responseText);
           }
      });
  }

  DataTablesEditor.prototype.create = function () {
	  var action = "create";
	  this.clearModal();
	  this.resetModalStatus(action);
	  this.getModal().modal('show').find('.alert').hide();
  }

  DataTablesEditor.prototype.modalCreate = function () {
	  this.postData("create", this.createCallback);
  }

  DataTablesEditor.prototype.createCallback = function (response) {
	  if(this.setError(response.fieldErrors)) {
		  return;
	  }

	  if(response.row != null) {
		  this.$dataTabls.row.add(response.row).draw();
		  this.getModal().modal("hide")
	  }
  }

  DataTablesEditor.prototype.edit = function () {
	  var selectRow = this.$dataTabls.row('.selected');

      if(selectRow.length == 0) {
	      bootbox.alert(this.options.language.noRowSelectMessage);
	      return;
      }

      var action = "edit";
	  this.clearModal();
	  this.resetModalStatus(action);
	  this.setData(selectRow.data())
	  this.getModal().modal('show').find('.alert').hide()
  }

  DataTablesEditor.prototype.modalEdit = function () {
	  this.postData("edit", this.editCallback);
  }

  DataTablesEditor.prototype.editCallback = function (response) {
	  if(this.setError(response.fieldErrors)) {
		  return;
	  }

	  if(response.row != null) {
		  this.$dataTabls.row('.selected').data(response.row).draw(false);
		  this.getModal().modal("hide")
	  }
  }

  DataTablesEditor.prototype.remove = function () {

	  var $this = this;
	  var selectRow = this.$dataTabls.row('.selected');

      if(selectRow.length == 0) {
	      bootbox.alert(this.options.language.noRowSelectMessage);
	      return;
      }

	  bootbox.confirm(this.options.language.delteConfirmMessage, function(result){
		  if(!result) {
			  return;
		  }
		  $this.clearModal();
		  $this.setData(selectRow.data())
		  $this.postData("remove", $this.removeCallback);
	  });

  }

  DataTablesEditor.prototype.removeCallback = function (response) {
	  this.$dataTabls.row('.selected').remove().draw( false );
  }

  DataTablesEditor.prototype.action = function () {
	  var $this = $(this)
	  var dataTableId = $this.attr('data-target')
	  var $dataTableEditor = $("#" + dataTableId).data('datatables.editor')
	  var action = $this.attr('data-action')
	  $dataTableEditor[action]();
  }

  // DataTablesEditor PLUGIN DEFINITION
  // ========================

  function Plugin(option) {
    return this.each(function () {
      var $this   = $(this)
      var data    = $this.data('datatables.editor')
      var options = $.extend({}, DataTablesEditor.DEFAULTS, $this.data(), typeof option == 'object' && option)

      if (!data) $this.data('datatables.editor', (data = new DataTablesEditor(this, options)))
      if (typeof option == 'string') data[option]()
    })
  }

  var old = $.fn.dataTablesEditor

  $.fn.dataTablesEditor             = Plugin
  $.fn.dataTablesEditor.Constructor = DataTablesEditor


  // DataTablesEditor NO CONFLICT
  // ==================

  $.fn.dataTablesEditor.noConflict = function () {
    $.fn.dataTablesEditor = old
    return this
  }


  // DataTablesEditor DATA-API
  // ===============
  $(document)
	  .on('click.dataTablesEditor.data-api', '[dataTablesEditorRole="button"]',DataTablesEditor.prototype.action)
}(jQuery);