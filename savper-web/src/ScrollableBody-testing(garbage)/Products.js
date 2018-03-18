import React from 'react';


class Products extends React.Component {

  
  render() {

    return (
      <div>
        <SearchBar 
          filterText={this.props.filterText} 
          onUserInput={this.handleUserInput.bind(this)}/>

        <ProductTable 
          onProductTableUpdate={this.handleProductTable.bind(this)} 

          onRowAdd={this.handleAddEvent.bind(this)} 
          
          onRowDel={this.handleRowDel.bind(this)} 
          
          products={this.state.products} 
          
          filterText={this.state.filterText}/>
      </div>
    );

  }

}