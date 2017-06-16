angular.module('app', [])
    .controller('TodoListController', function($scope , $http , $location) {
        var todoList = this;
        todoList.todos = [];
        todoList.answers = [];

        todoList.addQ = function() {
            todoList.todos.push({score:todoList.score, type:todoList.type ,content:todoList.content, answer1:todoList.answer1});
            
            
            console.log("added Q");
            
            todoList.score = '';
            todoList.type = '';
            todoList.content = '';
            todoList.answer1 = '';
        };

        todoList.post = function() {
        	todoList.postG();
        	angular.forEach(todoList.todos, function(todo) {
                todoList.postQ(todo.score , todo.type , todo.content , todo.answer1);
            });
        };
        
        todoList.postQ = function(qScore , qType , qContent , qAnswer1){
        	
            console.log(

            		qScore+ " " +
            		qType + " " +
            		qContent + " " +
            		qAnswer1 + " "            
                
                );
                
        	
            var url = '/games/' + todoList.gameId  + '/questions/sqsa';
            
            var config = {
                    headers : {
                        'Content-Type': 'application/json;charset=utf-8;'
                    }
            }
            var data = {
                score: qScore,
                type: qType,
                content: qContent,
                answer1: qAnswer1
            };
             
            $http.post(url, data, config).then(function (response) {
            }, function (response) {
            });
             
        }
        
        todoList.postG = function(){
            var url = '/lessons/' +  todoList.lessonId + '/games';
            
            var config = {
                    headers : {
                        'Content-Type': 'application/json;charset=utf-8;'
                    }
            }
            var data = {
            	id: todoList.gameId, 
                name: todoList.gameName,
                description: todoList.gameDescription,
                type: todoList.gameType
            };
             
            $http.post(url, data, config).then(function (response) {
            }, function (response) {
            });
             
            todoList.gameName = "";
            todoList.gameDescription = "";
            todoList.lessonId = "";
            todoList.gameType = "";
        }
        
        todoList.getfunction = function(){
	        var url = '/games/' + todoList.gameId + '/questions';
	        
	        var config = {
	                headers : {
	                    'Content-Type': 'application/json;charset=utf-8;'
	                }
	        }
	        
	        $http.get(url, config).then(function (response) {
	        	todoList.todos = response.data;
	        }, function (response) {
	        });
	    }
    	
        
        todoList.addA = function() {
            todoList.answers.push(todoList.answer);
            
            console.log("added A");
            
            todoList.answer = '';
        };
        
        todoList.submit = function() {
        	
        	var Lscore = 0;
        	
        	for (var i=0 ; i<todoList.todos.length ; i++){
        		if (todoList.todos[i].answer1 == todoList.answers[i]){
        			console.log("equality : ");
        			Lscore = Lscore + todoList.todos[i].score;
        		}
        	}
        	
        	todoList.Fscore = Lscore;
        };
        
    });
