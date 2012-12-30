<div class="bar">
    <div class="bar-in">
        <ul class="menu">
            <li><a href="${Request.contextPath}/index">首页</a></li>
            <#list Request.categories as category>
            <li><a href="${Request.contextPath}/${category.code}">${category.label}</a><li>
            </#list>
        </ul>

        <div class="search">                        	
            <form class="ajax" action="#">
                <select name="category">
                    <option>成员</option>
                    <option>圈子</option>
                </select>
                <input type="text" name="keywords" />
                <input type="submit" value="搜索" />
            </form>
        </div>
    </div>
</div>