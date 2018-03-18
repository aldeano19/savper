import React from 'react';

import {ReviseFile} from '../Features/ReviseFile'

function TableHeaderRow(){
  return (
    <thead>
      <tr>
        <th scope="col" id="file-name-column">
          Name</th>
        <th scope="col" id="total-revisions-column">
          Revs</th>
        <th scope="col" id="notes-column">
          Note</th>
        <th scope="col" id="uploaded-column">
          Uploaded</th>
        <th scope="col" id="last-revisioned-column">
          Revisioned</th>
      </tr>
    </thead>
  );
}

class TableRow extends React.Component{
  render(){
    const file = this.props.file;
  
    const name = file.fileName;
    const revs = file.revisionNumber;
    const note = file.lastChangeNote;
    const uploaded = file.created;
    const revisioned = file.updated;
    
    return (
      <tr>
        <th scope="row">{name}</th>
        <td> {revs} </td>
        <td> {note} </td>
        <td> {uploaded} </td>

        <td>{revisioned} </td>

        <td>
          <ReviseFile 
            onReviseClick={this.props.onReviseClick} 
            fileName={name}/>
        </td>
      </tr>
    );
  }
}

function TableBody(props){
  const rows = [];

  props.files.map(function(file, index){
    const theKey = index + "_row_" + file.name;
    rows.push(
      <TableRow 
        key={theKey} 
        file={file}
        onReviseClick={props.onReviseClick}
      />)
  }, this);

  return (
    <tbody>
      {rows}
    </tbody>  
  );
}

export class Table extends React.Component{
  render(){
    const files = this.props.fileList;
    return (
      
        <table className="table table-striped center" >
        
          <TableHeaderRow/>

          <TableBody 
            files={files} 
            onReviseClick={this.props.onReviseClick}
          />  
          
        </table>
      
      
    );
  }
}