$(function () {
	
	var dataRelatorio;
	
	
	$(document).on("click", "#gerarRelatorioSintetico", function(event) {
		
		var ano = $("#ano").val();
		
		$.ajax({
			async: false,
			url: "/sisgo/relatorio/sintetico/tratamentos-realizados/" + ano + "/gerar",
			type: "post",
			dataType: "json",
			error: function(jqXHR, textStatus, errorThrown) {
				alert("Erro ao gerar relatorio!");
			},
			success: function(dataRelatorioJson) {
				dataRelatorio = alterarFormatoJson(dataRelatorioJson);
				gerarGrafico(ano, dataRelatorio);
				$(".botaoGerarRelatorioAnalitico").show();				
			}
		});	
		
	});
});

function gerarGrafico(ano, dataRelatorio) {

    $('#graficoRelatorio').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 1,//null,
            plotShadow: false
        },
        title: {
            text: 'Tratamentos Realizados em ' + ano
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
            name: 'Tratamento',
            data: JSON.parse(dataRelatorio)
        }]
    });	
}
