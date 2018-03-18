// Native libraries
import React from 'react';

// 3rd party libraries
// import Files from 'react-files'

// House components
import {AddFile} from './AddFile';

const addFileIcons = {
  green: "http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/green-document-plus-icon.png"
}

export class AddFileContainer extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      addFileIcon: addFileIcons.green
    }
  }

  render(){
    return (
      <AddFile 
        onClick={this.props.onClick}
        addFileIcon={this.state.addFileIcon}/>  
    );
  }
}