<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>

<h1>Testing email</h1>
<h3>Cell that spans two rows:</h3>
<table>
  <tr>
    <th>JobName:</th>
    <td>"${jenkinsText}"</td>
  </tr>
  <tr>
    <th>Job URL:</th>  
    <td>"${jenkinsUrl}"</td>      
  </tr>  
  <tr>
    <th rowspan="2">Phone:</th>
    <td>123-45-678</td>
  </tr>
  <tr>
    <td>212-00-546</td>
  </tr>
</table>

</body>
</html>
