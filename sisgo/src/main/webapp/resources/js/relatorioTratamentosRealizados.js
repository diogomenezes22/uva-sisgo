$(function () {
	
	var dataRelatorio;
	
	$.ajax({
		async: false,
		url: "/sisgo/relatorio/tratamentos-realizados/gerar",
		type: "post",
		dataType: "json",
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Erro ao gerar relatorio!");
		},
		success: function(dataRelatorioJson) {
			dataRelatorio = alterarFormatoJson(dataRelatorioJson);
		}
	});	
	
    $('#graficoRelatorio').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 1,//null,
            plotShadow: false
        },
        title: {
            text: 'Tratamentos Realizados em 2014'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: JSON.parse(dataRelatorio)
        }]
    });
});
