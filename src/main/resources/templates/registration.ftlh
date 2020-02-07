<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>

    ${message!''}
    <div class="mb-1">Getting started</div>
    <@l.login "/registration" true/>

</@c.page>