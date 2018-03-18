// Native libraries
import React from 'react';

// 3rd party libraries
// import Files from 'react-files'

// House components
import {SearchFile} from './SearchFile';

const searchFileIcons = {
  blue: "http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/blue-search-icon.png"
}

export class SearchFilesContainer extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      searchFileIcon: searchFileIcons.blue
    }
  }

  render(){
    return (
      <SearchFile
        searchFileIcon={this.state.searchFileIcon}/>
        
    );
  }
}