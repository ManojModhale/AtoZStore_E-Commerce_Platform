import { Injectable, Renderer2, RendererFactory2 } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ThemeService {
  private renderer: Renderer2;
  private currentTheme: string = 'light'; // Default theme

  constructor(private rendererFactory: RendererFactory2) {
    this.renderer = rendererFactory.createRenderer(null, null);
  }

  // Function to toggle between light and dark themes
  toggleTheme() {
    this.currentTheme = this.currentTheme === 'light' ? 'dark' : 'light';
    this.applyTheme();
  }

  // Function to apply the current theme
  private applyTheme() {
    const body = document.getElementsByTagName('body')[0];
    this.renderer.removeClass(body, this.currentTheme === 'light' ? 'dark-theme' : 'light-theme');
    this.renderer.addClass(body, this.currentTheme === 'light' ? 'light-theme' : 'dark-theme');
  }
}
