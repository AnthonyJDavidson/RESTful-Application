import { Injectable } from '@angular/core';
import { Message } from './../model/Message';
import * as _ from 'lodash';

@Injectable()
export class ChartDataService {

  constructor() { }

  createCurrencyHeadingsFromData(messages: Message[]): string[] {
    const data: string[] = [];
    for (let i = 0; i < messages.length; i++) {
      if (data.indexOf(messages[i].originatingCountry.trim()) < 0) {
        data.push(messages[i].originatingCountry.trim());
      }
    }
    return data;
  }


  getDataForHeadingsPieChart(labels: string[], messages: Message[]): number[] {
    const data: number[] = [];

    for (let x = 0; x < labels.length; x++) {
      for (let i = 0; i < messages.length; i++) {
        if (messages[i].originatingCountry.trim() === labels[x].trim()) {
          data[x] === undefined ? data[x] = 1 : data[x]++ ;
        }
      }
    }
    return data;
  }

  getDataForHeadingsBarChart(labels: string[], messages: Message[], barChartData: number[] ): void {

    // Current Year only
    const date = new Date();
    const currentYear = date.getFullYear();
    for (let i = 0; i < messages.length; i++) {
      const dateMessage = new Date(messages[i].timePlaced);
      const dateInt = dateMessage.getMonth();
      const messageYear = dateMessage.getFullYear();
      if (messageYear === currentYear) {
              barChartData[dateInt]++;
      }
    }
  }

}
