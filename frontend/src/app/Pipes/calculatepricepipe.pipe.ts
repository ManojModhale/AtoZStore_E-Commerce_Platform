import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'calculatepricepipe'
})
export class CalculatepricepipePipe implements PipeTransform {

  transform(basePrice: number, offer: string): number {
    // Parse the offer string to get the discount percentage
    const discountPercentage = parseFloat(offer.replace('%', ''));

    // Calculate the final price after discount
    const finalPrice = basePrice - (basePrice * discountPercentage / 100);

    return finalPrice;
  }

}
