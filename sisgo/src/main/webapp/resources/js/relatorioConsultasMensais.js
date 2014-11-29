$(function () {
	
	var dataRelatorio;
	
	
	$(document).on("click", "#gerarRelatorioSintetico", function(event) {
	
		var ano = $("#ano").val();
		
		$.ajax({
			async: false,
			url: "/sisgo/relatorio/sintetico/consultas-mensais/" + ano + "/gerar",
			type: "post",
			dataType: "json",
			error: function(jqXHR, textStatus, errorThrown) {
				alert("Erro ao gerar relatorio");
			},
			success: function(dataRelatorioJson) {
				dataRelatorio = alterarFormatoJson(dataRelatorioJson);
				gerarGrafico(ano, dataRelatorio);
				$(".botaoGerarRelatorioAnalitico").show();
			}
		});	

	});
	
	$(document).on("click", "#gerarRelatorioAnalitico", function(event) {
		
		window.open("/sisgo/relatorio/analitico/consultas-mensais/" + $("#ano").val() + "/gerar","_blank");
	});	
});

function gerarGrafico(ano, dataRelatorio) {

    $('#graficoRelatorio').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Consultas Mensais em ' + ano
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Consultas Agendadas'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: '<b>{point.y} consultas</b>'
        },
        series: [{
            name: 'Consultas',
            data: JSON.parse(dataRelatorio),
            dataLabels: {
                enabled: false,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });	
}