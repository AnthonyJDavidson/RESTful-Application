import { Injectable } from '@angular/core';
import { RequestOptions, Http, Headers } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/toPromise';

import { Message } from '../model/Message'

@Injectable()
export class MessagesService {

  private headers = new Headers({'Content-Type': 'application/json',  'Accept': 'application/json', 'Access-Control-Allow-Origin': '*' });
  private options = new RequestOptions({headers: this.headers});
  private messagesUrl = 'http://localhost:8080/messaging-ws/messages';

  constructor(private http: Http) { }

  getMessages(): Promise<Message[]> {
    console.log('Calling endpoint for messages: ' + this.messagesUrl, this.options);
    return this.http
               .get(this.messagesUrl)
               .toPromise()
               .then(response => response.json() as Message[])
               .catch(this.handleError);
  }


  private handleError(error: any): Promise<any> {
    console.error('Error Calling messaging endpoint', error);
    return Promise.reject(error.message || error);
  }

}
