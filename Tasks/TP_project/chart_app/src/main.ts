import jsonData from './data.json';
import { Chart } from 'chart.js/auto';
import ChartDataLabels from 'chartjs-plugin-datalabels';

Chart.register(ChartDataLabels);  // ✅ Register the plugin


console.log("🚀 Script loaded");

interface Data{
    month:string;
    product:string;
    sales:number;
    profit:number;
    temperature:number;
}

//getting html elements
const ctx =document.getElementById('salesChart') as HTMLCanvasElement;
const xSelect=document.getElementById('x-category-select') as HTMLSelectElement
const ySelect=document.getElementById('y-category-select') as HTMLSelectElement
const chartSelect=document.getElementById('chart-type-select') as HTMLSelectElement

//setting a state
let currChart:Chart|null=null;


function renderChart(xKey: keyof Data, yKey: keyof Data, chartType: string) {
  // Group and format the data
  const labels:string = jsonData.map(item => item[xKey]);
  const data:number = jsonData.map(item => item[yKey] as number);

  if (currChart) currChart.destroy();

  currChart = new Chart(ctx, {
    type: chartType as any,
    data: {
      labels: labels,
      datasets: [{
        label: `${yKey} by ${xKey}`,
        data: data,
        backgroundColor: chartType === 'pie' ||chartType==='doughnut' ? colors : 'rgba(138, 177, 75, 0.5)',
        borderColor: 'rgba(75, 192, 192, 1)',
        borderWidth: 1
      }]
    },
    options: {
      responsive: true,
      scales: chartType !== 'pie' ? {
        y: {
          beginAtZero: true
        }
      } : undefined
    }
  });
}

renderChart('month','sales','bar');

//adding event listners
[xSelect, ySelect, chartSelect].forEach(el => {
  el.addEventListener('change', () => {
    const xValue = xSelect.value as keyof Data;
    const yValue = ySelect.value as keyof Data;
    const chartType = chartSelect.value;
    renderChart(xValue, yValue, chartType);
  });
});

const colors = [
  'rgba(255, 99, 132, 0.6)',
  'rgba(27, 104, 156, 0.6)',
  'rgba(242, 181, 27, 0.6)',
  'rgba(156, 203, 203, 0.99)',
  'rgb(153, 102, 255)',
  'rgba(255, 160, 64, 0.96)',
  'rgb(199, 199, 199)',
  'rgba(83, 103, 255, 0.53)',
];
