import React from 'react';

import {ProductRow} from './ProductRow';

class ProductRowContainer extends React.Component{
  render(){
    return (
      <ProductRow 
        onDelEvent={this.props.onDelEvent}
        onProductTableUpdate={this.props.onProductTableUpdate}
        product={this.props.product}
        />
    );
  }
}