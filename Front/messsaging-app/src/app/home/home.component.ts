import { Component, OnInit } from '@angular/core';
import { MessagesService } from './../common/service/messages.service'
import { Observable } from 'rxjs/Observable';
import { Message } from './../common/model/Message'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private messages: Message[];

  constructor(private messageService: MessagesService) { }

  ngOnInit() {
    this.messages = [];
    this.getMessages();
  }

  getMessages(): void {
    this.messageService.getMessages().then(messages => this.messages = messages);
  }

}
