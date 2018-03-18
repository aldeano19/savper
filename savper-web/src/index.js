// Native libraries
import React from 'react';
import ReactDOM from 'react-dom';

// 3rd party libraries
import ReactUploadFile from 'react-upload-file';


// House components
import {Table} from './TableManager/Table';
import {AddFileContainer} from './Features/AddFileContainer';
import {SearchFilesContainer} from './Features/SearchFilesContainer';

// Styles
import './Style/simple-style.css';

class App extends React.Component{
  constructor(props){
    super(props);
    this.state = {
      fileList: []
    }

    this.handleAddFile = this.handleAddFile.bind(this);
    this.handleRevisionClick = this.handleRevisionClick.bind(this);
  }

  componentDidMount() {
    const myLocalNetworkIp = "localhost";

    fetch("http://"+ myLocalNetworkIp +":8090/upload") 
            .then(function(result){
                return result.json();
            }).then(data => {
              this.setState({fileList:data});
            });
  }

  handleAddFile(newFiles){
    
    for (var i = 0; i < newFiles.length; i++) {
      var data = new FormData();
      data.append("fileIn", newFiles[i]);
      data.append("notes", "Default notes.");

      fetch("http://localhost:8090/upload", {
        method: 'POST',
        body: data
      }).then(function(result){
          return result.json();
      }).then(data => {
        console.log("POST response data: ");
        console.log(data);
      });
    }
    
    const myLocalNetworkIp = "localhost";
    fetch("http://"+ myLocalNetworkIp +":8090/upload") 
      .then(function(result){
          return result.json();
      }).then(data => {
        this.setState({fileList:data});
      }); 
  }

  handleRevisionClick(revisedFile, name){
    if(name !== revisedFile.name){
      alert("New file name=" + revisedFile.name + " does not match current name=" + name);
      return;
    }

    var data = new FormData();
    data.append("fileIn", revisedFile);

    var revisionNotes = "Revision notes."

    fetch("http://localhost:8090/upload?notes="+revisionNotes, {
      method: 'PATCH',
      qs: {"notes":"Yess"},
      body: data
    }).then(function(result){
        return result.json();
    }).then(data => {
      console.log("PATCH response data: ");
      console.log(data);
    });
  }

	render(){
    const options = {
      baseUrl: 'localhost',
      query: {
        warrior: 'fight'
      }
    }



		return (
      <div id="page1">
        <div id="action-menu">

          <AddFileContainer onClick={this.handleAddFile} />

          <ReactUploadFile 
            options={options} 
            chooseFileButton={<SearchFilesContainer />} 
            uploadFileButton={<SearchFilesContainer />} />

          
          
        </div>
        <Table
          fileList={this.state.fileList}
          onReviseClick={this.handleRevisionClick}
        />
      </div>
    );
	}
}

ReactDOM.render(<App/>, document.getElementById('app'));
