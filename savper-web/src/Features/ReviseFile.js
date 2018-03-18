// Native libraries
import React from 'react';

// 3rd party libraries
import Files from 'react-files'

class ReviseFileAction extends React.Component{
  constructor(props){
    super(props);
    // alert(this.props.fileName);
    this.state = {
      newFiles: [],
      fileToRevise: this.props.fileName
    }
    this.onFilesChange = this.onFilesChange.bind(this);
  }

  onFilesChange(newFiles) {
    console.log(newFiles);

    this.props.onReviseClick(newFiles[0], this.state.fileToRevise);
    this.setState({
      newFiles : [],
      fileToRevise: null
    });
  }

 
  onFilesError(error, file) {
    console.log('error code ' + error.code + ': ' + error.message + " &&: " + this.state.newFiles);
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
          maxFiles={1}
          maxFileSize={1048576}
          minFileSize={0}
          clickable
          onClick={this.onFilesChange}>
          <img 
            src="http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/32/yellow-address-book-icon.png"
            alt="Why Add..." 
            align="left"/>

        </Files>
      </div>
    )
  }
}


export function ReviseFile(props){
  return ( 
      <ReviseFileAction 
        onReviseClick={props.onReviseClick} 
        fileName={props.fileName}/>
    );
}