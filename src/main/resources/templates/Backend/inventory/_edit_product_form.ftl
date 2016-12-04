<form action="/add_new_product" METHOD="POST" id="demo-form2" data-parsley-validate=""
      class="form-horizontal form-label-left" novalidate="">


    <input type="hidden" value="" name="ID" id="ID">
    <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name <span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="text" id="name" required="required" name="name" class="form-control col-md-7 col-xs-12">
        </div>
    </div>

    <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="supplier">Supplier <span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="text" id="supplier" required="required" name="supplier" class="form-control col-md-7 col-xs-12">
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">Description
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <textarea id="description" required="required" class="form-control" name="description"
                      data-parsley-trigger="keyup" data-parsley-minlength="3" data-parsley-maxlength="120"
                      data-parsley-minlength-message="Come on! You need to enter at least a 3 caracters long comment.."
                      data-parsley-validation-threshold="10"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="price">Price <span class="required">*</span>
        </label>
        <div class="col-md-6 col-sm-6 col-xs-12">
            <input type="number" min="1" step="any" id="price" required="required" name="price" class="form-control col-md-7 col-xs-12"/>

        </div>
    </div>

    <div class="ln_solid"></div>
    <div class="form-group">
        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
    </div>
</form>