<html>

<head>
    <meta charset="utf-8">
    <title>商品列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        商品名称
                    </th>
                    <th>
                        商品价格
                    </th>
                    <th>
                        商品描述
                    </th>
                </tr>
                </thead>
                <tbody>

                <#list goodsPage.getContent() as goods>

                <tr>
                    <td>
                        ${goods.getId()}
                    </td>
                    <td>
                        ${goods.getName()}
                    </td>
                    <td>
                        ${goods.getPrice()}
                    </td>
                    <td>
                        ${goods.getDescription()}
                    </td>
                </tr>

                </#list>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>



<#--<h1>商品列表</h1>-->

<#--<h1>商品总数: ${goodsPage.getTotalElements()}</h1>-->

<#--<#list goodsPage.getContent() as goods>-->
<#--${goods.getName()}   ${goods.getPrice()}  ${goods.getDescription()} </br>-->
<#--</#list>-->