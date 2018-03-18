// Native libraries
import React from 'react';

// 3rd party libraries
import Files from 'react-files'

class AddFilesAction extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      files: []
    }
  }

  onFilesChange(newFiles) {
    this.props.onClick(newFiles);
    this.setState({newFiles : []});
  }
 
  onFilesError(error, file) {
    console.log('error code ' + error.code + ': ' + error.message);
  }
 
  render() {
    return (
      <div className="files">
        <Files
          className='files-dropzone'
          onChange={this.onFilesChange}
          onError={this.onFilesError}
          // accepts={['image/png', 'text/plain', 'audio/*']}
          multiple
          // maxFiles={3}
          maxFileSize={1048576}
          minFileSize={0}
          clickable
          onClick={this.props.onClick}>
          <img 
            src={this.props.addFileIcon}
            alt="Why Add..." 
            align="left"/>
        </Files>
      </div>
    )
  }
}


export function AddFile(props){
  return ( 
      <AddFilesAction 
        onClick={props.onClick}
        addFileIcon={props.addFileIcon}
        />
    );
}