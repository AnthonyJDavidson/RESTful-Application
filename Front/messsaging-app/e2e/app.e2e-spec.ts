import { MesssagingAppPage } from './app.po';

describe('messsaging-app App', () => {
  let page: MesssagingAppPage;

  beforeEach(() => {
    page = new MesssagingAppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
