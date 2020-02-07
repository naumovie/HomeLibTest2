<#macro login path isRegisterForm>
    <form action = "${path}"  method="post">
        <div class="form-group">
            <label class="col-sm-2 col-form-label"> User Name: </label>
            <div class="col-sm-6">
            <input type="text"
                   name="username"
                   class="form-control"
                   placeholder="Enter user name"
                   />
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Password: </label>
            <div class="col-sm-6">
                <input class="form-control"
                       type="password"
                       name="password"
                       placeholder="Enter password"/>
            </div>
        </div>

        <#if isRegisterForm>
            <div class="form-group">
                <label class="col-sm-2 col-form-label"> Confirm password: </label>
                <div class="col-sm-6">
                    <input class="form-control"
                           type="password"
                           name="password2"
                           placeholder="Enter password"/>
                </div>
            </div>

        <div class="form-group">
            <label class="col-sm-2 col-form-label"> Email: </label>
            <div class="col-sm-6">
                <input class="form-control"
                       name="email"
                       placeholder="Enter email"
                       />
            </div>
        </div>
        </#if>

        <#if !isRegisterForm>
            <a href="/registration">Sign up</a>
        </#if>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div>
            <button type="submit"
            class="btn btn-primary mt-3">
                <#if isRegisterForm>Create<#else>Sign In</#if>
            </button>
        </div>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary">
            Sign out
        </button>
    </form>
</#macro>