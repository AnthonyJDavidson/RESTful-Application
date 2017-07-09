import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { MessagesService } from './common/service/messages.service'

import { DataTablesModule } from 'angular-datatables';
import { ChartsModule } from 'ng2-charts';
import { PieChartComponent } from './pie-chart/pie-chart.component';

import { ChartDataService } from './common/service/chart-data.service';
import { BarChartComponent } from './bar-chart/bar-chart.component'


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    PieChartComponent,
    BarChartComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    DataTablesModule,
    ChartsModule
  ],
  providers: [MessagesService, ChartDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
