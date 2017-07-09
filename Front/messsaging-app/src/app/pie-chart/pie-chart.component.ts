import { Component, OnInit, Input } from '@angular/core';

import { Message } from './../common/model/Message'
import { ChartDataService } from './../common/service/chart-data.service'

@Component({
  selector: 'app-pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent implements OnInit {

  // Pie
  public pieChartLabels: string[] = [];
  public pieChartData: number[] = [];
  public pieChartType  = 'pie';

  @Input()
  messages: Message[]

  constructor(private chartDataService: ChartDataService ) {

   }

  ngOnInit() {

    // get distinct labels
    let pieChartLabels: string[] = [];
    pieChartLabels = this.chartDataService.createCurrencyHeadingsFromData(this.messages);
    this.pieChartLabels = pieChartLabels;

    let pieChartData: number[] = [];
    pieChartData = this.chartDataService.getDataForHeadingsPieChart(this.pieChartLabels, this.messages);
    this.pieChartData = pieChartData;
  }
  // events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }

}
