import React from 'react';

class ProductTable extends React.Component {

  render() {
    return (
      <div>
        <button type="button" onClick={this.props.onRowAdd} className="btn btn-success pull-right">Add</button>
        
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>Name</th>
              <th>price</th>
              <th>quantity</th>
              <th>category</th>
            </tr>
          </thead>

          <tbody>
            {this.props.product}
          </tbody>

        </table>
      </div>
    );

  }

}