import React from 'react';

export class EditableCell extends React.Component {

  render() {
    const cellData = this.props.cellData;
    return (
      <td>
        <input 
          type='text' 
          name={cellData.type} 
          id={cellData.id} 
          value={cellData.value} 
          onChange={this.props.onProductTableUpdate}/>
      </td>
    );

  }

}