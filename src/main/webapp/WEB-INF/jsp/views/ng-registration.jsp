<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<div ng-app ng-controller="RegistrationCtrl">
    <form class="form-horizontal" id="myForm">
        <input type="text" ng-model="user.name" size="20" placeholder="Name"> <br>
        <input type="text" ng-model="user.lastName" size="20" placeholder="lastName"> <br>
        <input type="email" ng-model="user.email" size="20" placeholder="email">  <br>
        <input type="text" ng-model="user.phone" size="20" placeholder="phone">   <br>
        <input type="date" ng-model="user.birthday" size="20" placeholder="<spring:message code="label.birthday"/>">  <br>

         <select ng-model="user.country">
            <option ng-repeat="country in countries" value="{{country.code}}">{{country.name}}</option>
        </select> <br>

        <a href="#/" class="btn">Cancel</a>
        <button ng-click="createUser()" ng-disabled="isClean() || myForm.$invalid"
                class="btn btn-primary">Save</button>
        <button ng-click="createUserJSON()" ng-disabled="isClean() || myForm.$invalid"
                class="btn btn-primary">Save JSON</button>
        <button ng-click="destroy()"
                ng-show="project._id" class="btn btn-danger">Delete</button>
    </form>
    <div ng-show="newUserId > 0">
        <p><spring:message code="message.user.registered" /> </p>
        <p>New ID: {{newUserId}}</p>
    </div>
    <div ng-show="errors" class="text-error">
        <p>Errors: {{errorMessage}}</p>
        <p ng-repeat="error in errors">E: {{error}}</p>
    </div>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js"></script>
    <!--script src="js/app.js"></script-->
</div>