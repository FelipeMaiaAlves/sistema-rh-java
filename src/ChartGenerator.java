import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.util.List;

public class Grafico {
    public void gerarGraficoSalarios(List<Funcionario> funcionarios, String caminho) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Funcionario f : funcionarios) {
            dataset.addValue(f.getSalario(), "Salário", f.getNome());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Salários dos Funcionários",
                "Funcionário",
                "Salário",
                dataset
        );

        try {
            org.jfree.chart.ChartUtilities.saveChartAsPNG(new File(caminho), chart, 800, 600);
            System.out.println("Gráfico gerado com sucesso em: " + caminho);
        } catch (Exception e) {
            System.out.println("Erro ao gerar gráfico: " + e.getMessage());
        }
    }
}
