<#import "parts/common.ftlh" as c>


<@c.page>
    <h3>Available books</h3>

    <div class="card-columns">
        <#list books as book>
        <a href="/">
            <div class="card my-3">
                <#if book.cover??>
                <img class="card-img-top"
                     src="/img/${book.cover}">
                </#if>

                <div class="m-2">
                    <span>Title: ${book.title}</span><br>
                    <span>Author: ${book.author!'unkown'}</span><br>
                    <span>Description:${book.description!''}</span><br>
                    <span>ISBN:${book.isbn!''}</span>
                </div>
            </div>
            </#list>
        </a>
    </div>

</@c.page>