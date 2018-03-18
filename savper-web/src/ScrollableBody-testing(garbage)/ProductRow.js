import React from 'react';

import {EditableCell} from './EditableCell';

export class ProductRow extends React.Component {
  onDelEvent() {
    this.props.onDelEvent(this.props.product);
  }

  render() {
    const product = this.props.product;
    const onProductTableUpdate = this.props.onProductTableUpdate;

    return (
      <tr className="eachRow">
        <EditableCell 
          onProductTableUpdate={onProductTableUpdate} 

          cellData={{
            "type": "name",
            value: product.name,
            id: product.id
          }}/>
        
        <EditableCell 
          onProductTableUpdate={onProductTableUpdate} 

          cellData={{
            type: "price",
            value: product.price,
            id: product.id
          }}/>

        <EditableCell 
          onProductTableUpdate={onProductTableUpdate} 

          cellData={{
            type: "qty",
            value: product.qty,
            id: product.id
          }}/>

        <EditableCell 
          onProductTableUpdate={onProductTableUpdate} 
          
          cellData={{
            type: "category",
            value: product.category,
            id: product.id
          }}/>

        <td className="del-cell">
          <input 
            type="button" 
            onClick={this.onDelEvent.bind(this)} 
            value="X" 
            className="del-btn"/>
        </td>
      </tr>
    );
  }
}