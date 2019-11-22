function getCommodities(){
    $.ajax({
        type:'GET',
        url:"http://localhost:8080/commodity?page=0&size=10&sortBy=commodityTitle&direction=ASC",
        dataType:'json'
    }).done(function (response) {
        console.log('Response',response);
        var commodities = response.data;
        for (var i=0;i<commodities.length;i++){
            var commodity=commodities[i];
            $('#listBrands').append('<li>'+brand.brandTitle+'</li>'+'<button onclick="deleteBrand('+brand.id+')">XXX</button>');
        }
    }).fail(function (e) {
        alert(e.message);
        console.log("mistake",e);
    })
}
//getBrands();