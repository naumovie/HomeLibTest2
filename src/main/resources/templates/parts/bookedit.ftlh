<#macro eddit>
<form action = "bookedit.ftlh"  method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Title: </label>
        <div class="col-sm-6">
            <input type="text"
                   name="title"
                   class="form-control"
                   placeholder="Enter title"
            />
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Author: </label>
        <div class="col-sm-6">
            <input type="text"
                   name="author"
                   class="form-control"
                   placeholder="Enter author"
            />
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 col-form-label"> Description: </label>
        <div class="col-sm-6">
            <textarea class="form-control"
                      name="text"
                      rows="4" cols="50"
                      placeholder="Enter description"></textarea>
        </div>
    </div>

    <div class="form-group">
        <label class="col-sm-2 col-form-label"> ISBN: </label>
        <div class="col-sm-6">
            <input type="text"
                   name="isbn"
                   class="form-control"
                   placeholder="Enter isbn"
            />
        </div>
    </div>

    <div class="form-group">
        <div class="custom-file">
            <label class="custom-file-label col-sm-6" for="coverFile">
                Choose file:</label>
            <input type="file" name="cover" id = "coverFile">
        </div>
    </div>

    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Add</button>

</form>
</#macro>