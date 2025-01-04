import { Component } from '@angular/core';

@Component({
  selector: 'app-testimonials',
  templateUrl: './testimonials.component.html',
  styleUrl: './testimonials.component.css'
})
export class TestimonialsComponent {

  testimonials = [
    [
      { name: 'Mr. Rahil', message: 'Ive been shopping at this store for years and Im always impressed by their wide selection of products. ' },
      { name: 'Ms. Rohan', message: 'I recently made a purchase from this store and was pleasantly surprised by how quickly my order arrived.' },
      { name: 'Mr. Soham', message: '"I had a minor issue with an order I placed, but the customer support team went  beyond to resolve it quickly and efficiently. ' }
    ],
    [
      { name: 'Ajay Thakur', message: '" The products I received were of decent quality.  they met my expectations , there were a few minor imperfections in one of the items.' },
      { name: 'Mahendra Singh', message: 'I had a question about my order, and their customer service team was quick to respond and very helpful. ' },
      { name: 'Rahul', message: 'Shipping was relatively fast considering the current circumstances. My order arrived within the estimated timeframe, and packaging was secure.' }
    ],
    [
      { name: 'Atharwa', message: 'Navigating the AtoZStore website was easy, and I found the items I was looking for without any hassle. However, the search function could be improved for better accuracy.'},
      { name: 'Daniel', message: ' Im satisfied with my experience shopping at AtoZStore. While there were minor issues with product quality and website usability, their excellent customer service.' },
      { name: 'Sejal', message: 'I would recommend AtoZStore to others looking for a convenient online shopping experience. With a wide range of products and responsive customer service.'}
    ]
    // Add more testimonials as needed
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
