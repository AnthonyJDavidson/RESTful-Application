import { Component, OnInit, Input } from '@angular/core';

import { Message } from './../common/model/Message'
import { ChartDataService } from './../common/service/chart-data.service'

@Component({
  selector: 'app-bar-chart',
  templateUrl: './bar-chart.component.html',
  styleUrls: ['./bar-chart.component.css']
})
export class BarChartComponent implements OnInit {

  @Input()
  messages: Message[]

 public barChartOptions: any = {
    scaleShowVerticalLines: false,
    responsive: true
  };
  public barChartLabels: string[] = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
  public barChartType: string = 'bar';
  public barChartLegend: boolean = true;

  public barChartData: any[] = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

  constructor(private chartDataService: ChartDataService ) {

   }

  ngOnInit() {
    // get distinct labels
    this.chartDataService.getDataForHeadingsBarChart(this.barChartLabels, this.messages, this.barChartData);
    this.barChartData = [{ data: this.barChartData, label: 'Number Transactions'}];
  }
  // events
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
  }
}

