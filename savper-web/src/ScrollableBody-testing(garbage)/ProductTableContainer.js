import React from 'react';

import {ProductRowContainer} from './ProductRowContainer'

class ProductTableContainer extends React.Component {

  render() {
    var onProductTableUpdate = this.props.onProductTableUpdate;

    var filterText = this.props.filterText;

    var product = this.props.products.map(function(product) {
      
      if (product.name.indexOf(filterText) === -1) {
        return;
      }

      return (
        <ProductRowContainer 
          onProductTableUpdate={onProductTableUpdate} 
          product={product} 
          onDelEvent={rowDel.bind(this)} 
          key={product.id}/>
      )
    });


    return (
      <ProductTable 
        onClick={this.props.onRowAdd}
        product={product}/>
    );

  }

}